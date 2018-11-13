package com.mystique.springdrivercard.controllers;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.services.cardApplicationFormService.CardApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>CardApplicationFormController</h1>
 *
 * <b>Description: </b> This is a Rest Controller using the CardApplicationService class which
 * defines requests to the "/api/applications" URL and derived paths. Requests in this controller
 * are associated with the CardApplicationForm model. It includes two(2) GET requests (get all and get by id),
 * a post request, and a put request.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@RestController
@RequestMapping("/api/applications")
public class CardApplicationFormController {
    private CardApplicationService service;

    @Autowired
    public CardApplicationFormController(CardApplicationService cardApplicationService) {
        this.service = cardApplicationService;
    }

    @PostMapping("/new")
    public CardApplicationForm addCardApplicationForm(@RequestBody CardApplicationForm cardApplicationForm) {
        return service.addCardApplicationForm(cardApplicationForm);
    }

    @GetMapping
    public List<CardApplicationForm> getAllCardApplications() {
        return service.getAllCardApplications();
    }

    @GetMapping("/{id}")
    public CardApplicationForm getCardApplicationByID(@PathVariable int id) {
        return service.getCardApplicationByID(id);
    }

    @PutMapping("/{id}")
    public CardApplicationForm updateCardApplication(@PathVariable int id,
                                      @RequestBody CardApplicationForm cardApplicationForm) {
        return service.updateCardApplication(id, cardApplicationForm);
    }
}
