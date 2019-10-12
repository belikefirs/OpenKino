package com.controller;

import com.models.Discount;
import com.service.DiscountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
@AllArgsConstructor
public class DiscountController {
    private DiscountService discountService;
    @PostMapping("")
    public Long save(@RequestBody Discount discount){
        return discountService.save(discount);
    }
    @PutMapping("")
    public Long update(@RequestBody Discount discount){
        return discountService.update(discount);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        discountService.delete(id);
    }
    @GetMapping("/id")
    public Discount get(@PathVariable Long id){
        return discountService.get(id);
    }
    @GetMapping("/all")
    public List<Discount> all(){
        return discountService.getAll();
    }
}
