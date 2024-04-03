package com.example.genshinapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.genshinapp.R

@Composable
fun SearchBar(
    keyword: String,
    onKeywordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = keyword,
        onValueChange = onKeywordChange,
        singleLine = true,
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "")
        },
        placeholder = {
            Text(text = stringResource(id = R.string.search_agent))
        },
        modifier = modifier.padding(12.dp).fillMaxWidth().heightIn(minOf(24.dp)).clip(
            RoundedCornerShape(36.dp)
        )
    )
}