/*
 * This file is generated by jOOQ.
 */
package brs.schema.tables;


import brs.schema.Db;
import brs.schema.Indexes;
import brs.schema.Keys;
import brs.schema.tables.records.IndirectIncomingRecord;

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
public class IndirectIncoming extends TableImpl<IndirectIncomingRecord> {

    private static final long serialVersionUID = 729564943;

    /**
     * The reference instance of <code>DB.indirect_incoming</code>
     */
    public static final IndirectIncoming INDIRECT_INCOMING = new IndirectIncoming();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<IndirectIncomingRecord> getRecordType() {
        return IndirectIncomingRecord.class;
    }

    /**
     * The column <code>DB.indirect_incoming.db_id</code>.
     */
    public final TableField<IndirectIncomingRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.indirect_incoming.account_id</code>.
     */
    public final TableField<IndirectIncomingRecord, Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.indirect_incoming.transaction_id</code>.
     */
    public final TableField<IndirectIncomingRecord, Long> TRANSACTION_ID = createField("transaction_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.indirect_incoming.height</code>.
     */
    public final TableField<IndirectIncomingRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>DB.indirect_incoming</code> table reference
     */
    public IndirectIncoming() {
        this(DSL.name("indirect_incoming"), null);
    }

    /**
     * Create an aliased <code>DB.indirect_incoming</code> table reference
     */
    public IndirectIncoming(String alias) {
        this(DSL.name(alias), INDIRECT_INCOMING);
    }

    /**
     * Create an aliased <code>DB.indirect_incoming</code> table reference
     */
    public IndirectIncoming(Name alias) {
        this(alias, INDIRECT_INCOMING);
    }

    private IndirectIncoming(Name alias, Table<IndirectIncomingRecord> aliased) {
        this(alias, aliased, null);
    }

    private IndirectIncoming(Name alias, Table<IndirectIncomingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> IndirectIncoming(Table<O> child, ForeignKey<O, IndirectIncomingRecord> key) {
        super(child, key, INDIRECT_INCOMING);
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
        return Arrays.<Index>asList(Indexes.INDIRECT_INCOMING_INDIRECT_INCOMING_DB_ID_UINDEX, Indexes.INDIRECT_INCOMING_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<IndirectIncomingRecord, Long> getIdentity() {
        return Keys.IDENTITY_INDIRECT_INCOMING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<IndirectIncomingRecord> getPrimaryKey() {
        return Keys.KEY_INDIRECT_INCOMING_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<IndirectIncomingRecord>> getKeys() {
        return Arrays.<UniqueKey<IndirectIncomingRecord>>asList(Keys.KEY_INDIRECT_INCOMING_PRIMARY, Keys.KEY_INDIRECT_INCOMING_INDIRECT_INCOMING_DB_ID_UINDEX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IndirectIncoming as(String alias) {
        return new IndirectIncoming(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IndirectIncoming as(Name alias) {
        return new IndirectIncoming(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public IndirectIncoming rename(String name) {
        return new IndirectIncoming(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public IndirectIncoming rename(Name name) {
        return new IndirectIncoming(name, null);
    }
}
