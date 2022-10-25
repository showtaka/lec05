package oit.is.z1180.kaizi.lec05.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1180.kaizi.lec05.model.Fruit;
import oit.is.z1180.kaizi.lec05.model.FruitMapper;

@Controller
@RequestMapping("/sample5")
public class Sample51Controller {

  @Autowired
  FruitMapper fMapper;

  @GetMapping("step1")
  public String sample51() {
    return "sample51.html";
  }

  @GetMapping("step2")
  public String sample52(ModelMap model) {
    ArrayList<Fruit> fruits2 = fMapper.selectAllFruit();
    model.addAttribute("fruits2", fruits2);
    return "sample51.html";
  }

  @GetMapping("step3")
  @Transactional
  public String sample53(@RequestParam Integer id, ModelMap model) {
    Fruit fruit3 = fMapper.selectById(id);
    model.addAttribute("fruit3", fruit3);

    fMapper.deleteById(id);

    ArrayList<Fruit> fruits2 = fMapper.selectAllFruit();
    model.addAttribute("fruits2", fruits2);
    return "sample51.html";
  }
  /*
   * @GetMapping("step4")
   *
   * @Transactional
   * public String sample54(@RequestParam Integer id, ModelMap model) {
   * Fruit fruit4 = fMapper.selectById(id);
   * model.addAttribute("fruit4", fruit4);
   *
   * ArrayList<Fruit> fruits2 = fMapper.selectAllFruit();
   * model.addAttribute("fruits2", fruits2);
   * return "sample51.html";
   * }
   *
   * @PostMapping("step5")
   * public String sample55(@RequestParam Integer id, @RequestParam String
   * name, @RequestParam Integer price,
   * ModelMap model) {
   * System.out.println("step5");
   * System.out.println(id);
   * System.out.println(name);
   * System.out.println(price);
   * Fruit fruit = new Fruit(id, name, price);
   *
   * fMapper.updateById(fruit);
   *
   * ArrayList<Fruit> fruits2 = fMapper.selectAllFruit();
   * model.addAttribute("fruits2", fruits2);
   *
   * return "sample51.html";
   * }
   */
}
