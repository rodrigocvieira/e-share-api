package ronjones.share;

public enum TokenEnum {

    VALID("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjozMjUwMTk2MjgwMH0.aHxCByfh9SQwo1K2LIgbuflAfcBwVMj5Ve1KtZAN-rg"),
    INVALID("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");

    private String value;

    TokenEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
