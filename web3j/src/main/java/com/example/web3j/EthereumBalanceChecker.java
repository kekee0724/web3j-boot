package com.example.web3j;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EthereumBalanceChecker {

    public static void main(String[] args) {
        // 以太坊节点的 HTTP RPC URL
        String ethereumRpcUrl = "http://localhost:8545"; // 替换为你的节点 URL

        // 创建 Web3j 客户端
        Web3j web3j = Web3j.build(new HttpService(ethereumRpcUrl));

        // 要查询余额的以太坊账户地址
        String addressToCheck = "0xABcaA14C902f7E1eBdD0bB13a50cEFADe10bf69b"; // 替换为要查询的地址

        try {
            // 查询账户余额
            EthGetBalance balanceResponse = web3j.ethGetBalance(addressToCheck, DefaultBlockParameterName.LATEST).send();
            BigInteger weiBalance = balanceResponse.getBalance();

            // 将余额从 Wei 转换为 Ether
            BigDecimal etherBalance = Convert.fromWei(new BigDecimal(weiBalance), Convert.Unit.ETHER);

            System.out.println("以太坊账户地址：" + addressToCheck);
            System.out.println("账户余额（Ether）：" + etherBalance);
        } catch (Exception e) {
            System.err.println("发生错误：" + e.getMessage());
        }
    }
}