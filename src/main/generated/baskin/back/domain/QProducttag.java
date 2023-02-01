package baskin.back.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProducttag is a Querydsl query type for Producttag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProducttag extends EntityPathBase<Producttag> {

    private static final long serialVersionUID = 1981891200L;

    public static final QProducttag producttag = new QProducttag("producttag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> product_id = createNumber("product_id", Long.class);

    public final NumberPath<Long> tag_id = createNumber("tag_id", Long.class);

    public QProducttag(String variable) {
        super(Producttag.class, forVariable(variable));
    }

    public QProducttag(Path<? extends Producttag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProducttag(PathMetadata metadata) {
        super(Producttag.class, metadata);
    }

}

