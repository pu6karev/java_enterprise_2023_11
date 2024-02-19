{{- define "serviceName" -}}
{{- printf "%s-%s" .Release.Name .Values.serviceSuffix.server -}}
{{- end -}}

{{- define "postgresServiceName" -}}
{{- printf "%s-%s" .Release.Name .Values.serviceSuffix.postgres -}}
{{- end -}}