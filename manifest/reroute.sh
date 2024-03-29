#!/bin/bash

POD_NAME=$(kubectl get pods -l app=bank-manager -o jsonpath='{.items[0].metadata.name}')

kubectl port-forward $POD_NAME 8080:8080

echo "** Access to the application at http://localhost:8080 **"