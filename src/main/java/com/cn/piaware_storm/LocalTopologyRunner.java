package com.cn.piaware_storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import backtype.storm.utils.Utils;

import com.cn.piaware_storm.topology.HelloWorldx5;
import com.cn.piaware_storm.topology.PassThru;
import com.cn.piaware_storm.topology.PiAwareFeedListener;
import com.cn.piaware_storm.topology.PrintToStdout;

/**
 * Created by robertweidlich on 1/13/17.
 */
public class LocalTopologyRunner {
    String urlStr = null;
    LocalTopologyRunner(String urlStr) {
        this.urlStr = urlStr;

    }

    public void run() {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("hello-world-x5", new HelloWorldx5());

        builder
                .setBolt("pass-thru", new PassThru())
                .shuffleGrouping("hello-world-x5");
        builder
                .setBolt("print-to-stdout", new PrintToStdout())
                .fieldsGrouping("pass-thru", new Fields("line"));

        Config config = new Config();
        config.setDebug(true);

        StormTopology topology = builder.createTopology();

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("git-passthru-topology", config, topology);

        Utils.sleep(60000);
        cluster.killTopology("git-passthru-topology");
    }
}
