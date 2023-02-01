package baskin.back.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductAllergy is a Querydsl query type for ProductAllergy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductAllergy extends EntityPathBase<ProductAllergy> {

    private static final long serialVersionUID = -1340499130L;

    public static final QProductAllergy productAllergy = new QProductAllergy("productAllergy");

    public final NumberPath<Long> allergy_id = createNumber("allergy_id", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> product_id = createNumber("product_id", Long.class);

    public QProductAllergy(String variable) {
        super(ProductAllergy.class, forVariable(variable));
    }

    public QProductAllergy(Path<? extends ProductAllergy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductAllergy(PathMetadata metadata) {
        super(ProductAllergy.class, metadata);
    }

}

