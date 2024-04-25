package com.raven.core.rule

import com.raven.models.entity.NewEntity
import org.junit.rules.TestWatcher

class TestDatabaseWatcher : TestWatcher() {

    companion object {
        fun getModel(): NewEntity  =
            NewEntity(
                id = 1,
                period = 1,
                uri = "",
                url = "",
                assetId = 2,
                source = "",
                byline = "",
                publishedDate = "",
                updatedTime = "",
                type = "",
                title = "",
                description = "",
                copyright = "",
                urlImage = "",
                format = ""
            )
    }
}