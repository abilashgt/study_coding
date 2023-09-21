Keytool:
```
keytool -import -v -keystore <java-location>/cacerts -trustcacerts -file <organization-pem-file>.pem
```

validate keystore:
```
# keytool -list -keystore <keystore-file-name>.keystore -storepass <alpha-numberic-password>
eg response: keytool error: java.io.IOException: keystore password was incorrect
```
