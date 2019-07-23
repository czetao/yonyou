package czt.yonyou.controller;

import czt.yonyou.dao.AgentRepository;
import czt.yonyou.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillController {

    @Autowired
    AgentRepository agen;

    //查询所有(/bill) HttpMethod为GET，返回客户端为所有Bill的集合，HttpStatus Code为OK
    @GetMapping("/bill")
    public String index(Model model){
        model.addAttribute("journal", agen.findAll());
        return "index";
    }



}
