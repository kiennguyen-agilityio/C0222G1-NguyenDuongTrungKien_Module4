package com.codegym.controller;
import com.codegym.model.Music;
import com.codegym.service.impl.MusicServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicServiceImp serviceImp ;

    @GetMapping("")
    public String index(Model model) {
        List<Music> musics = serviceImp.getAll();
        model.addAttribute("musics", musics);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }
    @PostMapping("/save")
    public String create(@Validated @ModelAttribute("music") Music music, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasFieldErrors()) {
            return "create";
        } else {
            serviceImp.save(music);
            redirectAttributes.addFlashAttribute("msg", "đăng kí thành công");
            return "redirect:";
        }
    }
    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", serviceImp.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("music") Music music, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasFieldErrors()) {
            return "edit";
        } else {
            serviceImp.update(music);
            redirectAttributes.addFlashAttribute("msg", "sửa thành công");
            return "redirect:";
        }
    }
}
