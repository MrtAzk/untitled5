package SERVICE;

import DAO.ProductDAO;

public class ProductService {

    private final ProductDAO productDAO ;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = new ProductDAO();
    }
}
