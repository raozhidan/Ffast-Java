package com.feiduyang.pay.modules.weixinpay.controller;

import com.feiduyang.api.pay.IWeixinPayService;
import com.feiduyang.common.entity.pay.Product;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.pay.modules.weixinpay.util.mobile.MobileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.Map;

/**
 * @ClassName FeiDuYangWeixinPayController
 * @Author Zhidan.Rao
 * @Date 2018年07月06日 14:22
 * @Version 1.0.0
 **/
@SuppressWarnings("Duplicates")
@Api(tags = "微信支付")
@Controller
@RequestMapping(value = "/feiduyangPay")
public class FeiDuYangWeixinPayController {

    private static final Logger logger = LoggerFactory.getLogger(FeiDuYangWeixinPayController.class);
    @Autowired
    private IWeixinPayService weixinPayService;


    @ApiOperation(value = "H5支付(需要公众号内支付)")
    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public String pay(Product product, ModelMap map) {
        logger.info("H5支付(需要公众号内支付)");
        String url = weixinPayService.weixinPayMobile(product);
        return "redirect:" + url;
    }

    @ApiOperation(value = "公众号H5支付主页")
    @RequestMapping(value = "payPage", method = RequestMethod.GET)
    public String pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "weixin/payPage";
    }

    @ApiOperation(value = "纯H5支付(不建议在APP端使用)")
    @RequestMapping(value = "h5pay", method = RequestMethod.POST)
    public String h5pay(Product product, ModelMap map) {
        logger.info("纯H5支付(不建议在APP端使用)");
        //mweb_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟。
        String mweb_url = weixinPayService.weixinPayH5(product);
        if (StringUtils.isNotBlank(mweb_url)) {
            return "redirect:" + mweb_url;
        } else {
            return "redirect:https://blog.52itstyle.com";//自定义错误页面
        }
    }

    @ApiOperation(value = "小程序支付(需要HTTPS)")
    @RequestMapping(value = "smallRoutine", method = RequestMethod.POST)
    public String smallRoutine(Product product, ModelMap map) {
        logger.info("小程序支付(需要HTTPS)、不需要支付目录和授权域名");
        String url = weixinPayService.weixinPayMobile(product);
        return "redirect:" + url;
    }

    /**
     * 预下单(对于已经产生的订单)
     *
     * @param
     * @return 统一返回对象
     * @Author Zhidan.Rao
     * @Version 1.0.0
     */
    @SuppressWarnings("rawtypes")
    @ApiOperation(value = "预下单")
    @RequestMapping(value = "dopay", method = RequestMethod.POST)
    public ResponseInfo doPay(@RequestParam String outTradeNo, @RequestParam String totalFee,
                              @RequestParam String code) throws Exception {
        //获取code 这个在微信支付调用时会自动加上这个参数 无须设置
        return weixinPayService.doPay(outTradeNo, totalFee, code);
    }

    /**
     * 手机支付完成回调
     *
     * @param request
     * @param response
     * @Author 科帮网
     * @Date 2017年7月31日 更新日志
     * 2017年7月31日  科帮网 首次创建
     */
    @ApiOperation(value = "手机支付完成回调")
    @RequestMapping(value = "WXPayBack", method = RequestMethod.POST)
    public void WXPayBack(HttpServletRequest request, HttpServletResponse response) {
        String resXml = "";
        try {
            //解析XML
            Map<String, String> map = MobileUtil.parseXml(request);
            String return_code = map.get("return_code");//状态
            String out_trade_no = map.get("out_trade_no");//订单号
            if (return_code.equals("SUCCESS")) {
                if (out_trade_no != null) {
                    //处理订单逻辑
                    //todo 调用服务完成订单状态的修改

                    logger.info("微信手机支付回调成功订单号:{}", out_trade_no);
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                }
            } else {
                logger.info("微信手机支付回调失败订单号:{}", out_trade_no);
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            }
        } catch (Exception e) {
            logger.error("手机支付回调通知失败", e);
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        try {
            // ------------------------------
            // 处理业务完毕
            // ------------------------------
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
