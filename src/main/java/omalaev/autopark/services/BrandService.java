package omalaev.autopark.services;

import omalaev.autopark.models.Brand;
import omalaev.autopark.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findOne(int id) {
        Optional<Brand> findBrand = brandRepository.findById(id);
        return findBrand.orElse(null);
    }

    @Transactional
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Transactional
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Transactional
    public void update(int id, Brand updatedBrand) {
        updatedBrand.setBrand_id(id);
        brandRepository.save(updatedBrand);
    }
}
