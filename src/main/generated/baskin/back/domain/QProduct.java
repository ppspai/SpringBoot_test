package baskin.back.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 1202443994L;

    public static final QProduct product = new QProduct("product");

    public final NumberPath<Integer> caffeine = createNumber("caffeine", Integer.class);

    public final NumberPath<Long> category_Id = createNumber("category_Id", Long.class);

    public final StringPath description = createString("description");

    public final StringPath enName = createString("enName");

    public final NumberPath<Integer> fat = createNumber("fat", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath img_Url = createString("img_Url");

    public final NumberPath<Integer> kcal = createNumber("kcal", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> protein = createNumber("protein", Integer.class);

    public final NumberPath<Integer> salt = createNumber("salt", Integer.class);

    public final NumberPath<Integer> sugar = createNumber("sugar", Integer.class);

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

