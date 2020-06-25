package engine;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class QuizController {
    private List<quiz> questions = new ArrayList<>();
    private List<getquiz> getquestions = new ArrayList<>();
    private static int id = 0;

    public QuizController(){

    }
    @PostMapping(value = "/api/quizzes",consumes = "application/json")
    public getquiz getquiz(@RequestBody quiz q){
        questions.add(q);
        getquestions.add(new getquiz(id,q.getTitle(),q.getText(),q.getOptions()));
        id = id + 1;
        return new getquiz(id,q.getTitle(),q.getText(),q.getOptions());
    }


    @RequestMapping(value = "/api/quizzes/{question_id}/solve", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public feedback getfeedback(@PathVariable int question_id,answer ans){
        if(Objects.equals(questions.get(question_id-1).getAnswer(),ans.getAnswer())){
            return new feedback(true,"Congratulations, you're right!");
        }
        else {
            return new feedback(false,"Wrong answer! Please, try again.");
        }
    }
    @GetMapping(value = "/api/quizzes/{tempid}")
    public getquiz getquizbuid(@PathVariable int tempid){
        if(tempid>questions.size()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return new getquiz(tempid,questions.get(tempid-1).getTitle(),questions.get(tempid-1).getText(),questions.get(tempid-1).getOptions());
    }

    @GetMapping(value = "/api/quizzes")
    public List<getquiz> getallquestions(){
        return getquestions;
    }
}