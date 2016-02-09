/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.struct.wasbugs.wasbug14.fe;

import at.struct.wasbugs.wasbug14.fe.entities.Conv2PdfFiling;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@Named
public class JsfBean {

    @PersistenceContext(unitName = "conv2pdf")
    private EntityManager em;

    public List<Conv2PdfFiling> getFilings() {
        TypedQuery<Conv2PdfFiling> query = em.createNamedQuery(Conv2PdfFiling.QRY_FIND_READY, Conv2PdfFiling.class);
        query.setMaxResults(100);

        return query.getResultList();
    }


}

