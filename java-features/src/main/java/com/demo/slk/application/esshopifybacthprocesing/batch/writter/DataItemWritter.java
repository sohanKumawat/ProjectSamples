package com.demo.slk.application.esshopifybacthprocesing.batch.writter;

import org.springframework.batch.item.ItemWriter;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;

public interface DataItemWritter<T extends DataItemWrite> extends ItemWriter<T>{

}