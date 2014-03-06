package org.zerosign.krl.rest.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zerosign.krl.rest.adt.ImmutablePair;
import org.zerosign.krl.rest.constants.ServiceConstant;
import org.zerosign.krl.rest.response.Response;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public abstract class Request {

    public static enum RequestMethod {
        POST, GET, PUT, DELETE
    }

    private final String endpoint;
    private final List<ImmutablePair<String>> queryParams;
    private final List<ImmutablePair<String>> bodyParams;

    private final RequestMethod method;
    private HttpURLConnection connection;

    Request(RequestMethod method, String endpoint) {
        this.method = method;
        this.endpoint = endpoint;
        this.queryParams = new LinkedList<>();
        this.bodyParams = new LinkedList<>();
    }

    /**
     * To be used if it is GET request.
     *
     * @param key
     * @param value
     */
    protected void addBodyParam(String key, String value) {
        queryParams.add(new ImmutablePair<>(key, value));
    }

    /**
     * To be used if it is POST request
     *
     * @param key
     * @param value
     */
    protected void addQueryParam(String key, String value) {
        queryParams.add(new ImmutablePair<>(key, value));
    }

    public void build() throws MalformedURLException, IOException {

        URL url = null;

        if (method == null || method.equals(RequestMethod.DELETE)
                || method.equals(RequestMethod.PUT)) {

            Logger.getLogger(Request.class.getName()).log(Level.WARNING,
                    "Sorry this {0} not supported yet.", method.name());
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("?");
        
            for (ImmutablePair<String> pair : queryParams) {
                builder.append(String.format("%s=%s&",
                        pair.getFirst(), pair.getSecond()));
            }
        

        url = new URL(String.format("%s%s%s", ServiceConstant.BASE_URL,
                endpoint, builder.toString()));

        if (method.equals(RequestMethod.POST)) {
            url = new URL(ServiceConstant.BASE_URL + endpoint);

            final int length = bodyParams.size();

            for (ImmutablePair<String> pair : bodyParams) {
                connection.setRequestProperty(pair.getFirst(), pair.getSecond());
            }

        }

        connection = (HttpURLConnection) url.openConnection();

        connection.setConnectTimeout(5000);

        if (method.equals(RequestMethod.GET)) {
            connection.setRequestMethod(RequestMethod.GET.name());
        } else if (method.equals(RequestMethod.POST)) {
            connection.setRequestMethod(RequestMethod.POST.name());
        } else if (method.equals(RequestMethod.PUT)) {
            connection.setRequestMethod(RequestMethod.PUT.name());
        }

    }

    public Response execute() throws IOException {

        build();

        connection.setDoInput(true);
        connection.setDoOutput(true);

        final Response response = readResponse(connection);

        connection.disconnect();
        return response;
    }

    /**
     *
     * @param connection
     * @return
     */
    protected Response readResponse(final HttpURLConnection connection) {

        StringBuilder builder = new StringBuilder();

        Response message = new Response();
        try {
            message.setCode(connection.getResponseCode());

            message.setMessage(connection.getResponseMessage());

            if (message.getCode() == Response.ResponseCode.CORRECT_REQUEST) {

                final InputStream stream = connection.getInputStream();

                final int bufsize = 1024;
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(stream), bufsize)) {

                    CharBuffer buffers = CharBuffer.allocate(bufsize);

                    int length = 0;

                    while ((length = reader.read(buffers)) != -1) {
                        builder.append(String.copyValueOf(buffers.array(), 0, 
                                length));
                        buffers.clear();
                    }
                }
                message.setMessage(builder.toString());
            }

        } catch (IOException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.WARNING, 
                    ex.getMessage());
        }

        return message;

    }
}
