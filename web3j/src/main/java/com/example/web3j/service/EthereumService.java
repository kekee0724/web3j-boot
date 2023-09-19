package com.example.web3j.service;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

@Service
public class EthereumService {

    private final Web3j web3j;

    public EthereumService(Web3j web3j) {
        this.web3j = web3j;
    }

    // 在这里编写与以太坊的交互代码
}