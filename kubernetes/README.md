# Infrastructure

## Helm
Download helm from binaries
Add helm folder to system path variable 

In Helm 3, the stable repository is not set. You have to manually add it.
Then you can use stable charts like stable/prometheus-operator.

```shell
# add a chart repository
helm repo add --help
#Usage:
  # helm repo add [NAME] [URL] [flags]

# helm repo add stable https://kubernetes-charts.storage.googleapis.com
# Error: repo "https://kubernetes-charts.storage.googleapis.com" is no longer available; try "https://charts.helm.sh/stable" instead

helm repo add stable https://charts.helm.sh/stable
helm repo update
```

