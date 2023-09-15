package com.example.nationalparkmeetup.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.nationalparkmeetup.R

@Composable
fun CustomDialogLocation(
    title: String? = "Message",
    desc: String? = "Your Message",
    enableLocation: MutableState<Boolean>,
    onClick: () -> Unit
) {
    Dialog(
        onDismissRequest = { enableLocation.value = false }
    ) {
        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
                // .width(300.dp)
                // .height(164.dp)
                .background(
                    color = MaterialTheme.colors.onPrimary,
                    shape = RoundedCornerShape(25.dp, 5.dp, 25.dp, 5.dp)
                )
                .verticalScroll(rememberScrollState())

        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                //.........................Image: preview
                Image(
                    painter = painterResource(id = R.drawable.baseline_location_on_24),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    /*  colorFilter  = ColorFilter.tint(
                          color = MaterialTheme.colorScheme.primary
                      ),*/
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .height(120.dp)
                        .fillMaxWidth(),

                    )
                //.........................Spacer
                //.........................Text: title
                Text(
                    text = title!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        //  .padding(top = 5.dp)
                        .fillMaxWidth(),
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.primary,
                )
                Spacer(modifier = Modifier.height(8.dp))
                //.........................Text : description
                Text(
                    text = desc!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    letterSpacing = 1.sp,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.primary,
                )
                //.........................Spacer
                Spacer(modifier = Modifier.height(24.dp))

                //.........................Button : OK button
                val cornerRadius = 16.dp
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp),
                    onClick =onClick,
                    contentPadding = PaddingValues(),
                    shape = RoundedCornerShape(cornerRadius)
                ) {
                    Text(
                        text = "Enable",
                        fontSize = 20.sp
                    )
                }
                //.........................Spacer
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(onClick = {
                    enableLocation.value = false
                }) { Text("Cancel", style = MaterialTheme.typography.subtitle1) }


                Spacer(modifier = Modifier.height(24.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    val title = "message"
    val desc = "Your Message"
    val enableLocation: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }
    CustomDialogLocation(
        title,
        desc,
        enableLocation
    ) {
    }
}