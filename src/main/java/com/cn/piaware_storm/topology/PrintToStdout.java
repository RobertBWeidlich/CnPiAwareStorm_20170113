package com.cn.piaware_storm.topology;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Print data streaming into the Bolt
 */
public class PrintToStdout extends BaseBasicBolt {
    private Map<String, Integer> counts;

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // this bolt does not emit any values
    }

    public void prepare(Map stormConf, TopologyContext context) {
        counts = new HashMap<String, Integer>();
    }

    public void execute(Tuple tuple, BasicOutputCollector outputCollector) {
        String line = tuple.getStringByField("line");
        System.out.println(">>>" + line + "<<<");
    }

}
