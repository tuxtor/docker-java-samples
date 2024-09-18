#!/bin/bash

helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo add metrics-server https://kubernetes-sigs.github.io/metrics-server
helm repo add elastic https://helm.elastic.co
helm repo add open-telemetry https://open-telemetry.github.io/opentelemetry-helm-charts
helm repo update

helm upgrade --install --wait --timeout 15m --namespace monitoring --create-namespace kube-prometheus-stack prometheus-community/kube-prometheus-stack

helm upgrade --install --namespace metrics-server --create-namespace metrics-server metrics-server/metrics-server
kubectl patch deployment metrics-server --type=json -p '[{"op":"add","path":"/spec/template/spec/containers/0/args/-","value":"--kubelet-insecure-tls"}]' -n metrics-server

helm upgrade --install --wait --timeout 15m --namespace elastic-system --create-namespace elastic-operator elastic/eck-operator

#helm upgrade --install --wait --timeout 15m --create-namespace --namespace logging logging-operator oci://ghcr.io/kube-logging/helm-charts/logging-operator
#--set "manager.collectorImage.repository=otel/opentelemetry-collector-k8s" \

helm upgrade --install --namespace monitoring opentelemetry-operator open-telemetry/opentelemetry-operator \
--set "manager.collectorImage.repository=otel/opentelemetry-collector-contrib" \
--set admissionWebhooks.certManager.enabled=false \
--set admissionWebhooks.autoGenerateCert.enabled=true


kubectl create namespace menarini
