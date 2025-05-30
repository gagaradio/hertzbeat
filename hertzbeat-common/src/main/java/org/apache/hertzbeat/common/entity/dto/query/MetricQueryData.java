/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hertzbeat.common.entity.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Metric History Range Query Data
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Metric Query Data")
public class MetricQueryData {
    
    @Schema(title = "Metric Schema")
    private MetricSchema schema;

    @Schema(title = "metrics row values, first is the timestamp-ts", example = "[[29,32,44],[32,34,true]]")
    private List<List<Object>> values;

    /**
     * Metric Schema
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class MetricSchema {

        @Schema(title = "Metrics Field")
        private List<MetricField> fields;
        
        @Schema(title = "Meta Information")
        private Map<String, String> meta;
    }

    /**
     * Metric Field
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class MetricField {

        @Schema(title = "Metric Field Name")
        private String name;

        @Schema(title = "Field Type: number, string, time, bool")
        private String type;

        @Schema(title = "Field Unit: %, Mb, Kbps etc.")
        private String unit;

        @Schema(title = "Whether is a label")
        private Boolean label;
    }
}
