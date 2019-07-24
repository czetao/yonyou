package czt.yonyou.controller;


import czt.yonyou.dao.AgentRepository;
import czt.yonyou.dao.BillItemRepository;
import czt.yonyou.dao.BillRepository;
import czt.yonyou.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@Controller
public class BillController {

    @Autowired
    AgentRepository agen;
    @Autowired
    BillRepository billt;
    @Autowired
    BillItemRepository billItem;

    //查询所有(/bill) HttpMethod为GET，返回客户端为所有Bill的集合，HttpStatus Code为OK
    @GetMapping("/bill")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Bill> index( ){
        return billt.findAll();
    }

    //增加("/bill") HttpMethod为POST，返回客戶端为新增后的主键，HttpStatus Code为CREATED
    @RequestMapping(value = "/bill",method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)  //增加返回的状态码
    public List<Bill> add(@RequestBody Bill bill){


        //提取数据存进对象
        /*String code = obj.getString("code");
        String name = obj.getString("name");
        String department = obj.getString("department");
        Object billItems = obj.getJSONObject("billItems");
        //实体对象是list。可以通过转
        ArrayList<BillItem> ayy =(ArrayList<BillItem>) ((JSONObject) billItems).get("billItems");
        //构造函数新建对象
        Bill bi = new Bill(code,name,department,ayy);*/

        //通过requestBody接受传进来的json数据

        billt.save(bill);
        System.out.println(bill);
        return billt.findAll();
        //return bill.getId();
    }

    //删除("/bill/{id}") HttpMethod为DELETE，返回客戶端为空，HttpStatus Code为OK
    @RequestMapping(value = "/bill/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(Integer  id){
        billt.deleteById(id);
    }

    //修改("/bill/{id}") HttpMethod为PUT，返回客戶端为空，HttpStatus Code为OK
    @RequestMapping(value = "/bill/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Bill bill){

        //通过传进来的bill_id，改变原来bill_id的东西
        Bill bill2 = billt.findById(bill.getId()).get();
        bill2.setCode(bill.getCode());
        bill2.setName(bill.getName());
        bill2.setBillItems(bill.getBillItems());

        billt.save(bill2);

    }

    //查询("/bill/{id}") HttpMethod为GET，返回客户端为单個Bill对象，HttpStatus Code为OK
    @RequestMapping(value = "/bill/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Bill findByid(@PathVariable("id") Integer id){
        return billt.findById(id).get();

    }

}
