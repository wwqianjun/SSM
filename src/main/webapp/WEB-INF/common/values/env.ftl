<#-- taglib -->
<#global spring=JspTaglibs["http://www.springframework.org/tags"] />
<#global form=JspTaglibs["http://www.springframework.org/tags/form"] />

<#-- properties -->
<#global basepathC = req.contextPath/>
<#global host="${getEnv('server.host.static')}" />
<#global hosts="${getEnv('servers.host.static')!''}" />
<#global mediaserver="${getEnv('server.path.media')}" />
<#global httpsHost="${getEnv('server.https.host.static')!''}" />
<#global httpsHosts="${getEnv('servers.https.host.static')!''}" />
<#global httpsUrls="${getEnv('https.urls')!''}" />
<#global httpContext="http:${getEnv('server.context.url')!''}${basepathC}" />
<#global httpsContext="https:${getEnv('server.context.url')!''}${basepathC}" />
<#global basepath="http:${getEnv('server.context.url')!''}${basepathC}" />

