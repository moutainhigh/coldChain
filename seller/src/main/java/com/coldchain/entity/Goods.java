package com.coldchain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.common.utils.TimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.web.util.HtmlUtils;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Goods implements Serializable {
    @Id
    @ApiModelProperty(value = "商品id")
    @JsonProperty("goods_id")
    private Integer goodsId;

    @ApiModelProperty(value = "凭证id")
    @JsonProperty("depositCertificateId")
    private Integer depositCertificateId;

    @ApiModelProperty(value = "一级商品分类id")
    @JsonProperty("cat_id1")
    private Integer catId1;
    @ApiModelProperty(value = "二级商品分类id")
    @JsonProperty("cat_id2")
    private Integer catId2;
    @ApiModelProperty(value = "三级商品分类id")
    @JsonProperty("cat_id3")
    private Integer catId3;
    @ApiModelProperty(value = "店铺一级商品分类")
    @JsonProperty("store_cat_id1")
    private Integer storeCatId1;
    @ApiModelProperty(value = "店铺二级商品分类")
    @JsonProperty("store_cat_id2")
    private Integer storeCatId2;
    @ApiModelProperty(value = "商品编号")
    @JsonProperty("goods_sn")
    private String goodsSn;
    @NotBlank(message = "商品名称不能为空")
    @ApiModelProperty(value = "商品名称")
    @JsonProperty("goods_name")
    private String goodsName;
    @ApiModelProperty(value = "点击数")
    @JsonProperty("click_count")
    private Integer clickCount;
    @JsonProperty("brand_id")
    @ApiModelProperty(value = "品牌表主键")
    private Integer brandId;
    @NotNull(message = "请输入库存")
    @ApiModelProperty(value = "库存数量")
    @JsonProperty("store_count")
    private Integer storeCount;
    @ApiModelProperty(value = "商品收藏数")
    @JsonProperty("collect_sum")
    private Integer collectSum;
    @ApiModelProperty(value = "商品评论数")
    @JsonProperty("comment_count")
    private Short commentCount;
    @ApiModelProperty(value = "商品重量(克)")
    private Integer weight;
    @ApiModelProperty(value = "商品体积(立方米)")
    private Double volume;
    @Digits(integer = 7, fraction = 2, message = "本店售价格式不对")
    @DecimalMin(value = "0.01", message = "市场价格式不对")
    @DecimalMax(value = "9999999", message = "市场价格式不对")
    @NotNull(message = "市场价不能为空")
    @ApiModelProperty(value = "市场价(RMB)")
    @JsonProperty("market_price")
    private BigDecimal marketPrice;
    @Digits(integer = 7, fraction = 2, message = "本店售价格式不对")
    @DecimalMin(value = "0.01", message = "本店售价格式不对")
    @DecimalMax(value = "9999999", message = "本店售价格式不对")
    @NotNull(message = "本店售价不能为空")
    @ApiModelProperty(value = "本店价(RMB)")
    @JsonProperty("shop_price")
    private BigDecimal shopPrice;
    @ApiModelProperty(value = "商品成本价(RMB)")
    @JsonProperty("cost_price")
    private BigDecimal costPrice;
    @ApiModelProperty(value = "积分兑换(0不参与积分兑换)")
    @JsonProperty("exchange_integral")
    private Integer exchangeIntegral;
    @ApiModelProperty(value = "商品关键词")
    private String keywords;
    @ApiModelProperty(value = "商品简单描述")
    @JsonProperty("goods_remark")
    private String goodsRemark;
    @NotEmpty(message = "请上传商品图片")
    @ApiModelProperty(value = "商品主图url")
    @JsonProperty("original_img")
    private String originalImg;
    @ApiModelProperty(value = "是否为虚拟商品(1是,0否)")
    @JsonProperty("is_virtual")
    private Integer isVirtual;
    @ApiModelProperty(value = "虚拟商品有效截止日期(时间戳)")
    @JsonProperty("virtual_indate")
    private Integer virtualIndate;
    @ApiModelProperty(value = "虚拟商品购买上限")
    @JsonProperty("virtual_limit")
    private Short virtualLimit;
    @ApiModelProperty(value = "虚拟商品是否允许过期退款(1是,0否)")
    @JsonProperty("virtual_refund")
    private Integer virtualRefund;
    @ApiModelProperty(value = "0下架,1上架,2违规下架")
    @JsonProperty("is_on_sale")
    private Integer isOnSale;
    @ApiModelProperty(value = "是否包邮")
    @JsonProperty("is_free_shipping")
    private Integer isFreeShipping;
    @ApiModelProperty(value = "商品上架时间(时间戳)")
    @JsonProperty("on_time")
    private Long onTime;
    @ApiModelProperty(value = "商品排序权重值")
    private Short sort;
    @ApiModelProperty(value = "是否推荐")
    @JsonProperty("is_recommend")
    private Integer isRecommend;
    @ApiModelProperty(value = "是否新品")
    @JsonProperty("is_new")
    private Integer isNew;
    @ApiModelProperty(value = "是否热卖")
    @JsonProperty("is_hot")
    private Integer isHot;
    @ApiModelProperty(value = "最后更新时间(时间戳)")
    @JsonProperty("last_update")
    private String lastUpdate;
    @ApiModelProperty(value = "商品模型表主键")
    @JsonProperty("goods_type")
    private Integer goodsType;
    @ApiModelProperty(value = "购买商品时赠送积分")
    @JsonProperty("give_integral")
    private Integer giveIntegral;
    @ApiModelProperty(value = "真实的商品销量总数")
    @JsonProperty("sales_sum")
    private Integer salesSum;
    @ApiModelProperty(value = "商品虚拟销量总数")
    @JsonProperty("virtual_sales_sum")
    private Integer virtualSalesSum;
    @ApiModelProperty(value = "商品活动类型(0默认,1抢购,2团购,3优惠促销,4预售,5虚拟(其实没用),6拼团)")
    @JsonProperty("prom_type")
    private Integer promType;
    @ApiModelProperty(value = "商品活动主键")
    @JsonProperty("prom_id")
    private Integer promId;
    @ApiModelProperty(value = "佣金用于分销分成(RMB)")
    private BigDecimal distribut;
    @ApiModelProperty(value = "店铺表主键")
    @JsonProperty("store_id")
    private Integer storeId;
    @ApiModelProperty(value = "spu")
    private String spu;
    @ApiModelProperty(value = "sku")
    private String sku;
    @ApiModelProperty(value = "商品审核状态(0待审核,1审核通过,2审核失败)")
    @JsonProperty("goods_state")
    private Integer goodsState;
    @ApiModelProperty(value = "违规下架原因")
    @JsonProperty("close_reason")
    private String closeReason;
    @ApiModelProperty(value = "供应商表主键")
    @JsonProperty("suppliers_id")
    private Short suppliersId;
    @ApiModelProperty(value = "运费模板表主键")
    @JsonProperty("template_id")
    private Integer templateId;
    @ApiModelProperty(value = "视频地址url")
    private String video;
    @ApiModelProperty(value = "商品标签表主键")
    @JsonProperty("label_id")
    private String labelId;
    @ApiModelProperty(value = "关联版式头部")
    @JsonProperty("plate_top")
    private Integer plateTop;
    @ApiModelProperty(value = "关联版式底部")
    @JsonProperty("plate_bottom")
    private Integer plateBottom;
    @ApiModelProperty(value = "pc商品详细描述(html文本)")
    @JsonProperty("goods_content")
    private String goodsContent;

    @ApiModelProperty(value = "通证ID")
    @JsonProperty("dc_id")
    private Integer dcId;

    @ApiModelProperty(value = "商品拥有者的id")
    @JsonProperty("owner_id")
    private Integer ownerId;

    @ApiModelProperty(value = "商品证书")
    @JsonProperty("goods_certificate")
    private String goodsCertificate;


    public String getGoodsContent() {
        if (StringUtils.isNotEmpty(goodsContent)) {
            return HtmlUtils.htmlUnescape(goodsContent);
        }
        return null;
    }

    @ApiModelProperty(value = "移动端商品详细描述(html文本)")
    @JsonProperty("mobile_content")
    private String mobileContent;

    @ApiModelProperty(value = "商品总数")
    private Integer goodsCount;

    @ApiModelProperty(value = "1:第三方自营店,2:总平台自营店")
    private Integer isOwnShop;

    @ApiModelProperty(value = "当前商品的所属人")
    @JsonProperty("user_id")
    private Integer userId;

    @ApiModelProperty(value = "商品相册列表节点")
    private List<GoodsImages> goodsImages;

    @ApiModelProperty(value = "商品规格价格列表节点")
    private List<SpecGoodsPrice> specGoodsPriceList;

    @ApiModelProperty(value = "商品属性列表节点")
    private List<GoodsAttr> goodsAttrs;

    private static final long serialVersionUID = 1L;
}