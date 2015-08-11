/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2015 ForgeRock AS.
 */

package org.forgerock.selfservice.example;

import org.forgerock.selfservice.core.ProcessStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple local stores in memory.
 *
 * @since 0.1.0
 */
public final class BasicLocalStorage implements ProcessStore {

    private final Map<String, Map<String, String>> localStore;

    /**
     * Creates a new basic local storage instance.
     */
    public BasicLocalStorage() {
        localStore = new ConcurrentHashMap<>();
    }

    @Override
    public Map<String, String> remove(String key) {
        return localStore.remove(key);
    }

    @Override
    public void add(String key, Map<String, String> state) {
        localStore.put(key, state);
    }

}
