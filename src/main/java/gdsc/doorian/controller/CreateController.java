package gdsc.doorian.controller;

import gdsc.doorian.dto.CreateForm;
import gdsc.doorian.entity.Create;
import gdsc.doorian.repository.CreateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class CreateController {
    @Autowired
    private CreateRepository createRepository;
    @GetMapping("/templates/create")
    public String newCreateForm(){
        return "create";
    }
    @PostMapping("/templates/create")
    public String createCreate(CreateForm form){
        log.info(form.toString());
        Create create=form.toEntity();
        log.info(create.toString()); //dto->entity
        Create saved=createRepository.save(create);
        log.info(saved.toString()); //create->db
        return "";
    }
    @GetMapping("/templates")
    public String index(Model model){
        //데이터 가져오기
        ArrayList<Create> createEntityList=createRepository.findAll();
        //데이터 등록
        model.addAttribute("createList",createEntityList);
        //뷰 페이지 설정
        return  "showList";
    }
}

