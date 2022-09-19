<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Code</title>
    <link rel="stylesheet" href="/css/code.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <span id="load_date">${code.getDateFormatted()}</span>
    <#if code.isViewsRestricted() >
        <p>
            <span id="views_restriction">${code.getViews()} more views allowed</span>
        </p>
    </#if>
    <#if code.isTimeRestricted() >
        <p>
            <span id="time_restriction">The code will be available for ${code.getTimeLeft()} seconds</span>
        </p>
    </#if>
    <pre id="code_snippet">
        <code>${code.getCode()}</code>
    </pre>
</body>
</html>