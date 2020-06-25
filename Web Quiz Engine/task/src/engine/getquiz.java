package engine;

public class getquiz{

    private int id;
    private String title;
    private  String text;
    private String[] options;
    public getquiz(int id,String title,String text,String[] options){
        this.id = id;
        this.options = options;
        this.text = text;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
