package me.myshop.common.constant;

public enum GoodsTypeEnum {
    T1("1"), T2("2"), T3("3"), T4("4");

    private String index;

    GoodsTypeEnum(String index) {
        this.index = index;
    }

    public static GoodsTypeEnum compare(String goodsType) {
        if (GoodsTypeEnum.T1.toString().equals(goodsType)) {
            return GoodsTypeEnum.T1;

        } else if (GoodsTypeEnum.T2.toString().equals(goodsType)) {
            return GoodsTypeEnum.T2;

        } else if (GoodsTypeEnum.T3.toString().equals(goodsType)) {
            return GoodsTypeEnum.T3;

        } else {
            return GoodsTypeEnum.T4;
        }

    }


    @Override
    public String toString() {
        return index;
    }
}
