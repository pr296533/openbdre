/*
 * Copyright 2015 Wipro Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wipro.ats.bdre.wgen;

/**
 * Created by arijit on 12/23/14.
 */

/**
 * Methods getName() and getXML() for HaltJobNode
 * getXML() is formatting the string to be returned as XML format
 */


public class HaltJobNode extends OozieNode {

    public HaltJobNode() {

    }

    public String getName() {
        return "halt-job";
    }

    @Override
    public String getXML() {
        String ret = "\n<action name=\"halt-job\">\n" +
                "        <java>\n" +
                "            <job-tracker>${jobTracker}</job-tracker>\n" +
                "            <name-node>${nameNode}</name-node>\n" +
                "            <main-class>com.wipro.ats.bdre.md.api.oozie.OozieHaltJob</main-class>\n" +


                "            <arg>--process-id</arg>\n" +
                "            <arg>" + getId() + "</arg>\n" +
                "            <arg>--batch-marking</arg>\n" +
                "            <arg>${wf:actionData(\"init-job\")[\"target-batch-marking\"]}</arg>\n" +
                "        </java>\n" +
                "        <ok to=\"halt\"/>\n" +
                "        <error to=\"term-job\"/>\n" +
                "    </action>";

        return ret;
    }

}