package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.business.Code;
import platform.business.CodeService;

@RestController
public class CodeWebController {

    private final CodeService codeService;

    @Autowired
    public CodeWebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code")
    public String getCode() {
        Code code = codeService.get();
        return String.format("""
        <html>
        <head>
            <meta charset="utf-8">
            <title>Code</title>
            <link rel="stylesheet" href="/css/code.css">
        </head>
        <body>
            <span id="load_date">%s</span>
            <pre id="code_snippet">%s</pre>
        </body>
        </html>""", code.getDateFormatted(), code.getCode());
    }

    @GetMapping("/code/new")
    public String postCode() {
        return """
        <html>
        <head>
            <meta charset="utf-8">
            <title>Create</title>
            <link rel="stylesheet" href="/css/new-code.css">
        </head>
        <body>
            <form>
                <textarea id="code_snippet"></textarea>
                <button id="send_snippet" type="submit" onclick="send()">Submit</button>
            </form>
        </body>
        <script src="/js/script.js"></script>
        </html>""";
    }
}
