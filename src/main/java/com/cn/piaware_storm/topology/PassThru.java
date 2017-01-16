package com.cn.piaware_storm.topology;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/**
 * Bolt that simply passes data -- one line at a time -- unfiltered
 * Filters can be implemented by adding code in the execute() function
 */
public class PassThru extends BaseBasicBolt {
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("line"));
    }

    public void execute(Tuple tuple, BasicOutputCollector outputCollector) {
        String line = tuple.getStringByField("line");
        outputCollector.emit(new Values(line));
    }

}
