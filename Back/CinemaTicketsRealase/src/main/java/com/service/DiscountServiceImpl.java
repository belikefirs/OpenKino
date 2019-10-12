package com.service;

import com.dao.DiscountDao;
import com.dao.FilmDao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.models.Discount;
import com.models.Film;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private DiscountDao discountDao;
    private FilmDao filmDao;
    @Override
    public Long save(Discount discount) {
        //Film film = filmDao.findById(discount.getIdFilm()).get();
       // discount.setFilm(film);
        return discountDao.save(discount).getId();
    }

    @Override
    public Long update(Discount discount) {
        Discount discount1 = discountDao.findById(discount.getId()).get();
       // Film film = filmDao.findById(discount.getIdFilm()).get();
        discount1.setName(discount.getName());
        discount1.setPercent(discount.getPercent());
        discount1.setBirthdayUser(discount.getBirthdayUser());
      //  discount1.setFilm(film);
        discount1.setLastTimeFilmStart(discount1.getLastTimeFilmStart());
        discount1.setLastTimeFilmEnd(discount.getLastTimeFilmEnd());
        return discountDao.save(discount1).getId();
    }

    @Override
    public void delete(Long id) {
        discountDao.deleteById(id);
    }

    @Override
    public Discount get(Long id) {
        return discountDao.findById(id).get();
    }

    @Override
    public List<Discount> getAll() {
        return discountDao.findAll();
    }
}
