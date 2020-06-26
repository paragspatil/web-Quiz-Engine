package engine;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class QuizController {
    private List<quiz> questions = new ArrayList<>();
    private List<getquiz> getquestions = new ArrayList<>();
    private static int id = 0;

    public QuizController(){

    }



    @PostMapping(value = "/api/quizzes",consumes = "application/json")
    public getquiz getquiz(@RequestBody quiz q){
        System.out.println(q.getOptions().toString());
        System.out.println(q.getText());
        System.out.println(q);
        //String json = matchService.getMatchJson(q);
        if(q.getOptions().length<2 || Objects.equals(q.getTitle(),"") ||Objects.equals(q.getText(),"")){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "entity not found"
            );
        }

        else {
            questions.add(q);
            getquestions.add(new getquiz(id, q.getTitle(), q.getText(), q.getOptions()));
            id = id + 1;
            return new getquiz(id, q.getTitle(), q.getText(), q.getOptions());
        }
    }

    @RequestMapping(value = "/api/quizzes/{question_id}/solve", method = RequestMethod.POST,consumes = "application/json")
    public feedback getfeedback(@PathVariable int question_id,@RequestBody answer ans){
        System.out.println(ans.getAnswer().length);
        System.out.println(questions.get(question_id-1).getAnswer());
        if(questions.get(question_id-1).getAnswer() == null && ans.getAnswer().length == 0){
            return new feedback(true,"Congratulations, you're right!");
        }
        else if(Arrays.equals(ans.getAnswer(),questions.get(question_id-1).getAnswer())){
            return new feedback(true,"Congratulations, you're right!");
        }
        else {
            return new feedback(false,"Wrong answer! Please, try again.");
        }
    }
    @GetMapping(value = "/api/quizzes/{tempid}")
    public getquiz getquizbuid(@PathVariable int tempid){

        return new getquiz(tempid,questions.get(tempid-1).getTitle(),questions.get(tempid-1).getText(),questions.get(tempid-1).getOptions());
    }

    @GetMapping(value = "/api/quizzes")
    public List<getquiz> getallquestions(){
        return getquestions;
    }
}