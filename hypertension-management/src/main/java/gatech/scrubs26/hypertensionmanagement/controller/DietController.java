package gatech.scrubs26.hypertensionmanagement.controller;

import gatech.scrubs26.hypertensionmanagement.model.DietEntry;
import gatech.scrubs26.hypertensionmanagement.model.User;
import gatech.scrubs26.hypertensionmanagement.service.DietEntryService;
import gatech.scrubs26.hypertensionmanagement.utils.DietValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
public class DietController {
    @Autowired
    private DietEntryService dietEntryService;

    @Autowired
    private DietValidator dietValidator;

    // Load Diet Entry form page
    @GetMapping("/dietEntryPage")
    public String dietEntryPage(Model model, HttpServletRequest request) {
        model.addAttribute("dietForm", new DietEntry());

        // Only load today diet entry
        List<DietEntry> currentDietEntries = dietEntryService.findCurrentDietEntries(request.getParameter("username"));
        model.addAttribute("currentDietEntries", currentDietEntries);

        return "dietentry";
    }

    // Submit Diet Entry data and redirect to Diet Entry page with all info
    @PostMapping("/createDietEntry")
    public String createDietEntry(@ModelAttribute("dietForm") DietEntry dietForm, BindingResult bindingResult) {
        dietValidator.validate(dietForm, bindingResult);

        if (!bindingResult.hasErrors()) {
            dietEntryService.save(dietForm); // only save new diet entry after verifying the info
        }

        return "dietEntryPage"; // return to same diet entry form page
    }


    // Return all history of diet entries with evaluation
    @GetMapping(value = "/dietEntryHistory", produces = MediaType.APPLICATION_JSON_VALUE)
    public String dietEntryHistory(HttpServletRequest request) {

        List<DietEntry> currentDietEntries = dietEntryService.findByUsername(request.getParameter("username"));
        // Need to implement business logic to evaluate Diet entries

        return "diethistory";
    }
}
