Show Secrets
```
# kubectl describe secret <secret-name> -n <namespace>
```

Dumb existing secrets yaml
```
# kubectl get secret <secret-name> -n <namespace> -o yaml > <secret-name>.yaml
```

update the secrets yaml
```
kubectl apply -f <secret-name>.yaml
```

base 64 encode:
```
base64 -i <file-location> -o <output-file-location>.base64
```
