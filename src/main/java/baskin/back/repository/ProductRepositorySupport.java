package baskin.back.repository;

import baskin.back.domain.Product;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static baskin.back.domain.QProduct.product;
import static baskin.back.domain.QCategory.category;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public ProductRepositorySupport(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }

    public List<Product> findAll() {
        return queryFactory.selectFrom(product)
                .fetch();
    }

    public List<Tuple> testJoin() {
        return queryFactory.select(product,category)
                .from(product)
                .leftJoin(category).on(product.category_Id.eq(category.id))
                .fetch();
    }


}
