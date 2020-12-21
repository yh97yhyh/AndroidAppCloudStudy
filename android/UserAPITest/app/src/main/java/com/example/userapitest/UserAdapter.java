package com.example.userapitest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    int layout;
    ArrayList<User> list;
    CloudBlobContainer container;

    public UserAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        list = new ArrayList<>();
        String connectionString = context.getString(R.string.connectionString);
        CloudStorageAccount storageAccount = null;
        try {
            storageAccount = CloudStorageAccount.parse(connectionString);
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
            String containerName = context.getString(R.string.container_name);
            container = blobClient.getContainerReference(containerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        list.clear();
    }

    public void addItem(User user) {
        list.add(user);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(layout, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = list.get(position);
        holder.txtId.setText(user.id);
        holder.txtPass.setText(user.pass);
        holder.txtAddr.setText(user.addr);
        download(user.filename, holder.imageView);
    }

    void download(String filename, ImageView imageView) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CloudBlockBlob blob = container.getBlockBlobReference(filename);
                    if(blob.exists()){
                        blob.downloadAttributes();
                        ByteArrayOutputStream os = new ByteArrayOutputStream();
                        blob.download(os);
                        byte[] buffer = os.toByteArray();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(buffer, 0, buffer.length);

                        ((MainActivity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtPass, txtAddr;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_id);
            txtPass = itemView.findViewById(R.id.txt_pass);
            txtAddr = itemView.findViewById(R.id.txt_addr);
            imageView = itemView.findViewById(R.id.imageview_item);
        }
    }

    void downloadImage(String filename) {

    }
}
