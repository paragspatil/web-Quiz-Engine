package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class quiz implements Serializable {
    private  String title;
    private  String text;
    private String[] options;
    private  int[] answer;

    public quiz(String title,String text,String[] options,int[] answer){
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
    @JsonProperty("answer")
    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
    @JsonIgnore
    public int[] getAnswer() {
        return answer;
    }
}