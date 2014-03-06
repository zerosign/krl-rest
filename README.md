# Unofficial KRL Indonesia API Library

Please be aware that this is not official API. There is no warranty that 
this API always could be used and no harm to its users, so please see the
code before use it. If any claims happen to this library from the sources
this library will be shutdowned.


This repository are using maven repository, so you can use maven to add 
this library by simply add new repository to this github url, likes :
	
	<repositories>
		<repository>
			<id>krl-rest</id>
			<url>https://raw.github.com/zerosign/krl-rest/repository</url>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>
	</repositories>

Or probably you can just see the guides in [maven-plugins](https://github.com/github/maven-plugins).

For embedding this library using android you can either build it locally
or just use it build snapshots in [here](https://github.com/zerosign/krl-rest/tree/repository/org/zerosign/krl-rest/1.0).

This library are means to be minimalist library. this library only uses
gson library for serialization and deserialization of JsonObject (but 
currently are not being used). All network related classes are created 
only using commons java library (URLConnection) to make it less 
dependencies to other libraries. 

# License
* [MIT License](http://www.opensource.org/licenses/mit-license.php)
