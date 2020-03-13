package brs;

import brs.props.Props;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

public final class Constants {

    //修改此账号为总账号
    public static final long MAIN_ACCOUNT = 111;

    //所有代理账号以,连接
    public static final String AGENT_ACCOUNTS = "-222,-333,-444";
    //奖励给基金会比例5%
    public static final double MAIN_RATIO = 0.05;
    //节点奖励比例。。。这个由矿池控制。。这里无效
    public static final double NODE_RATIO = 0.10;

    //4年转换成秒
    public static final int FOUR_YEAR = 4 * 365 * 24 * 3600;

    //public static final double PLEDGE_LIMITATION = 1.3;

    public static final long ONE_DAY = 1000 * 1 * 24 * 3600l;

    //public static final int PLEDGE_REWARD = 10000 / 31;

    //每天固定奖励数为216W*100000000
    public static final BigDecimal ONE_DAY_REWARDS = new BigDecimal(21600000000000L);
    //块奖励 600
    public static final int BLOCK_REWARD = 600;
    //申请冻结时间 15天
    public static final long PLEDGE_FRONZEN_TIME = 1 * 1000 * 24 * 3600l;
    //public static final int PLEDGE_FRONZEN_TIME = 60000;
    //赎回单个周期 30天   （总赎回时间为15+30+30+30）
    public static final long REDEEM_PERIOD_TIME = 1 * 1000 * 24 * 3600l;
    //public static final int REDEEM_PERIOD_TIME = 120000;

    public static final int BURST_DIFF_ADJUST_CHANGE_BLOCK = 2700;

    public static final long BURST_REWARD_RECIPIENT_ASSIGNMENT_WAIT_TIME = 1;

    // not sure when these were enabled, but they each do an alias lookup every block if greater than the current height
    public static final long BURST_ESCROW_START_BLOCK = 0;
    public static final long BURST_SUBSCRIPTION_START_BLOCK = 0;
    public static final int BURST_SUBSCRIPTION_MIN_FREQ = 3600;
    public static final int BURST_SUBSCRIPTION_MAX_FREQ = 31536000;

    public static final int BLOCK_HEADER_LENGTH = 232;

    public static final long MAX_BALANCE_BURST = 2158812800L;

    public static final long FEE_QUANT = 735000;
    public static final long ONE_BURST = 100000000;

    public static final long MAX_BALANCE_NQT = MAX_BALANCE_BURST * ONE_BURST;
    public static final long INITIAL_BASE_TARGET = 18325193796L;
    public static final long MAX_BASE_TARGET = 18325193796L;
    public static final int MAX_ROLLBACK = Burst.getPropertyService().getInt(Props.DB_MAX_ROLLBACK);

    public static final int MAX_ALIAS_URI_LENGTH = 1000;
    public static final int MAX_ALIAS_LENGTH = 100;

    public static final int MAX_ARBITRARY_MESSAGE_LENGTH = 1000;
    public static final int MAX_ENCRYPTED_MESSAGE_LENGTH = 1000;

    public static final int MAX_MULTI_OUT_RECIPIENTS = 64;
    public static final int MAX_MULTI_SAME_OUT_RECIPIENTS = 128;

    public static final int MAX_ACCOUNT_NAME_LENGTH = 100;
    public static final int MAX_ACCOUNT_DESCRIPTION_LENGTH = 1000;

    public static final long MAX_ASSET_QUANTITY_QNT = 1000000000L * 100000000L;
    public static final long ASSET_ISSUANCE_FEE_NQT = 1000 * ONE_BURST;
    public static final int MIN_ASSET_NAME_LENGTH = 3;
    public static final int MAX_ASSET_NAME_LENGTH = 10;
    public static final int MAX_ASSET_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_ASSET_TRANSFER_COMMENT_LENGTH = 1000;

    public static final int MAX_POLL_NAME_LENGTH = 100;
    public static final int MAX_POLL_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_POLL_OPTION_LENGTH = 100;
    public static final int MAX_POLL_OPTION_COUNT = 100;

    public static final int MAX_DGS_LISTING_QUANTITY = 1000000000;
    public static final int MAX_DGS_LISTING_NAME_LENGTH = 100;
    public static final int MAX_DGS_LISTING_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_DGS_LISTING_TAGS_LENGTH = 100;
    public static final int MAX_DGS_GOODS_LENGTH = 10240;

    public static final int NQT_BLOCK = 0;
    public static final int REFERENCED_TRANSACTION_FULL_HASH_BLOCK = 0;
    public static final int REFERENCED_TRANSACTION_FULL_HASH_BLOCK_TIMESTAMP = 0;

    public static final int MAX_AUTOMATED_TRANSACTION_NAME_LENGTH = 30;
    public static final int MAX_AUTOMATED_TRANSACTION_DESCRIPTION_LENGTH = 1000;

    public static final String HTTP = "http://";

    public static final Version MIN_VERSION = Version.parse("v2.4.0");
    // TODO burstkit4j integration
    public static final long EPOCH_BEGINNING;
    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final int EC_RULE_TERMINATOR = 2400; /* cfb: This constant defines a straight edge when "longest chain"
                                                        rule is outweighed by "economic majority" rule; the terminator
                                                        is set as number of seconds before the current time. */
    public static final int EC_BLOCK_DISTANCE_LIMIT = 60;
    public static final int EC_CHANGE_BLOCK_1 = 67000;
    public static final String RESPONSE = "response";
    public static final String TOKEN = "token";
    public static final String WEBSITE = "website";
    public static final String PROTOCOL = "protocol";
    public static final int BLOCK_PROCESS_THREAD_DELAY = 500; // Milliseconds
    static final long UNCONFIRMED_POOL_DEPOSIT_NQT = (Burst.getPropertyService().getBoolean(Props.DEV_TESTNET) ? 50 : 100) * ONE_BURST;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.JUNE);
        calendar.set(Calendar.DAY_OF_MONTH, 30);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH_BEGINNING = calendar.getTimeInMillis();

        if (MAX_ROLLBACK < 1440) {
            throw new RuntimeException("brs.maxRollback must be at least 1440");
        }
    }

    private Constants() {
    } // never

}
