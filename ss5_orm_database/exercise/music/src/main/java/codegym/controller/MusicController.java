package codegym.controller;

import codegym.model.Music;
import codegym.service.impl.MusicServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MusicController {
    private MusicServiceImp serviceImp = new MusicServiceImp();

    @GetMapping("/list")
    public String index(Model model) {
        List<Music> musics = serviceImp.getAll();
        model.addAttribute("musics", musics);
        return "index";
    }

    @GetMapping("music/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("music/save")
    public String save(Music music, RedirectAttributes redirect) {
        serviceImp.save(music);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/list";
    }

    @RequestMapping("/music/{id}/delete")
    public String delete(@PathVariable(name = "id") int idMusic, RedirectAttributes redirect) {
        serviceImp.remove(idMusic);
        redirect.addFlashAttribute("success", "Deleted success");
        return "redirect:/list";
    }

    @RequestMapping("/music/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", serviceImp.findById(id));
        return "edit";
    }

    @PostMapping("/music/update")
    public String update(Music music, RedirectAttributes redirect) {
        serviceImp.update(music);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String searchByName(String name, Model model) {
        model.addAttribute("musics", serviceImp.search(name));
        return "index";
    }
}
