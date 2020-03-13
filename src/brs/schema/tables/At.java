/*
 * This file is generated by jOOQ.
 */
package brs.schema.tables;


import brs.schema.Db;
import brs.schema.Indexes;
import brs.schema.Keys;
import brs.schema.tables.records.AtRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class At extends TableImpl<AtRecord> {

    private static final long serialVersionUID = -143412697;

    /**
     * The reference instance of <code>DB.at</code>
     */
    public static final At AT = new At();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AtRecord> getRecordType() {
        return AtRecord.class;
    }

    /**
     * The column <code>DB.at.db_id</code>.
     */
    public final TableField<AtRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.at.id</code>.
     */
    public final TableField<AtRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.at.creator_id</code>.
     */
    public final TableField<AtRecord, Long> CREATOR_ID = createField("creator_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.at.name</code>.
     */
    public final TableField<AtRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>DB.at.description</code>.
     */
    public final TableField<AtRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>DB.at.version</code>.
     */
    public final TableField<AtRecord, Short> VERSION = createField("version", org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>DB.at.csize</code>.
     */
    public final TableField<AtRecord, Integer> CSIZE = createField("csize", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at.dsize</code>.
     */
    public final TableField<AtRecord, Integer> DSIZE = createField("dsize", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at.c_user_stack_bytes</code>.
     */
    public final TableField<AtRecord, Integer> C_USER_STACK_BYTES = createField("c_user_stack_bytes", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at.c_call_stack_bytes</code>.
     */
    public final TableField<AtRecord, Integer> C_CALL_STACK_BYTES = createField("c_call_stack_bytes", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at.creation_height</code>.
     */
    public final TableField<AtRecord, Integer> CREATION_HEIGHT = createField("creation_height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at.ap_code</code>.
     */
    public final TableField<AtRecord, byte[]> AP_CODE = createField("ap_code", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /**
     * The column <code>DB.at.height</code>.
     */
    public final TableField<AtRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at.latest</code>.
     */
    public final TableField<AtRecord, Boolean> LATEST = createField("latest", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>DB.at</code> table reference
     */
    public At() {
        this(DSL.name("at"), null);
    }

    /**
     * Create an aliased <code>DB.at</code> table reference
     */
    public At(String alias) {
        this(DSL.name(alias), AT);
    }

    /**
     * Create an aliased <code>DB.at</code> table reference
     */
    public At(Name alias) {
        this(alias, AT);
    }

    private At(Name alias, Table<AtRecord> aliased) {
        this(alias, aliased, null);
    }

    private At(Name alias, Table<AtRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> At(Table<O> child, ForeignKey<O, AtRecord> key) {
        super(child, key, AT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.AT_AT_CREATOR_ID_HEIGHT_IDX, Indexes.AT_AT_ID_HEIGHT_IDX, Indexes.AT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AtRecord, Long> getIdentity() {
        return Keys.IDENTITY_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AtRecord> getPrimaryKey() {
        return Keys.KEY_AT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AtRecord>> getKeys() {
        return Arrays.<UniqueKey<AtRecord>>asList(Keys.KEY_AT_PRIMARY, Keys.KEY_AT_AT_ID_HEIGHT_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public At as(String alias) {
        return new At(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public At as(Name alias) {
        return new At(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public At rename(String name) {
        return new At(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public At rename(Name name) {
        return new At(name, null);
    }
}
