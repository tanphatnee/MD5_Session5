package ss5.bt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ss5.bt.model.entity.Song;
import ss5.bt.model.service.ISongService;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping
    public String home(Model model){
        model.addAttribute("list",songService.findAll());
        return "home";
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("add","song",new Song());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        return new ModelAndView("edit","song",songService.findById(id));
    }

    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable Long id){
        songService.delete(id);
        return "redirect:/";
    }
    @PostMapping("add")
    public String doAdd (@Valid @ModelAttribute Song song, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "add";
        }
        songService.save(song);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String doUpdate(@Valid @ModelAttribute Song song, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        songService.save(song);
        return "redirect:/";
    }
}
